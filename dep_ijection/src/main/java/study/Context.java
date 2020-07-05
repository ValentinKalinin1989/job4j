package study;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Context {
    private Map<String, Object> els = new HashMap<String, Object>();

    public void reg(Class cl) {

        Constructor[] constructors = cl.getConstructors();
        if (constructors.length > 1) {
            throw new IllegalStateException("Class has multi constructors: "
                    + cl.getCanonicalName());
        }

        Constructor constructor = constructors[0];
        List<Object> args = new ArrayList<Object>();
        for (Class arg : constructor.getParameterTypes()) {
            if (!els.containsKey(arg.getCanonicalName())) {
                throw new IllegalStateException("Object doesn't gound in context: "
                        + arg.getCanonicalName());
            }
            args.add(els.get(arg.getCanonicalName()));
        }

        try {
            els.put(cl.getCanonicalName(), constructor.newInstance(args.toArray()));
        } catch (Exception e) {
            throw new IllegalStateException("Coun't create an instance of: "
                    + cl.getCanonicalName(), e);
        }
    }

    public <T> T get(Class<T> ins) {
        return (T) els.get(ins.getCanonicalName());
    }
}
