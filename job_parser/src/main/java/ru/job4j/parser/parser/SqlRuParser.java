package ru.job4j.parser.parser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import ru.job4j.parser.utill.DateConverter;
import ru.job4j.parser.vacancy.Vacancy;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SqlRuParser {

    private String url;
    private static final Logger LOG = LogManager.getLogger(SqlRuParser.class.getName());

    public SqlRuParser(String url) {
        this.url = url;
    }

    private Document getPage(String url) throws IOException {
        Document page = Jsoup.parse(new URL(url), 2000);
        return page;
    }

    public List<Vacancy> parse() {
        LOG.info("Парсинг вакансий начат.");
        List<Vacancy> vacancyList = new ArrayList<>();
        LocalDate localDateYearLate = LocalDate.now().minusYears(1);
        int numberAllPage;
        try {
            Document page = getPage(this.url);
            String numOfPage = page.select("table[class=sort_options]").select("a").last().text();
            numberAllPage = Integer.parseInt(numOfPage);
            int i = 1;
            do {
                Document pageIn = getPage("https://www.sql.ru/forum/job-offers/".concat(String.valueOf(i)));
                Elements tableJobs = pageIn.select("tr");
                for (Element element : tableJobs) {
                    String jobName = element.select("td[class=postslisttopic]").select("a").text();
                    if (!jobName.contains("Javascript")
                            & !jobName.contains("Java script")
                            & !jobName.contains("Java-script")
                            & (jobName.contains("Java") || jobName.contains("java"))) {
                        LocalDate dateVacancy = DateConverter.convertToDate(element.select("td[class=altCol]td[style=text-align:center]").text());
                        if (dateVacancy.isBefore(localDateYearLate)) {
                            LOG.info("Вакансии за год проанализированы.");
                            i = numberAllPage + 1;
                            break;
                        }
                        String linkOnVac = element.select("td[class=postslisttopic]").select("a").attr("href");
                        vacancyList.add(new Vacancy(jobName, getInfoVacancy(linkOnVac), linkOnVac, dateVacancy));
                    }
                }
                i++;
            } while (i <= numberAllPage);
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
        }
        LOG.info("Парсинг вакансий закончен");
        return vacancyList;
    }

    /**
     * Get info about vacancy from link
     *
     * @param link link in string
     * @return info about vacancy
     */
    private String getInfoVacancy(String link) {
        String info = null;
        try {
            Document page = getPage(link);
            Elements elements = page.select("td[class=msgBody]");
            info = elements.get(1).text();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return info;
    }

    //static public void main(String[] args) {
    //    SqlRuParser sqlRuParser = new SqlRuParser("https://www.sql.ru/forum/job-offers");
    //    List<Vacancy> vacancyList = sqlRuParser.parse();
    //   vacancyList.stream().forEach(vacancy -> System.out.println(vacancy.toString()));
    //}

}
