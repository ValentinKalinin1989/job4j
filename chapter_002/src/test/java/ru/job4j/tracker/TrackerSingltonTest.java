package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerSingltonTest {
    @Test
    public void testTrackerEnum() {
        TrackerEnum trackerEnum1 = TrackerEnum.INSTANCE;
        TrackerEnum trackerEnum2 = TrackerEnum.INSTANCE;
        assertThat(trackerEnum1, is(trackerEnum2));
    }

    @Test
    public void testTrackerStaticField() {
        TrackerStaticField trackerEnum1 = TrackerStaticField.instance;
        TrackerStaticField trackerEnum2 = TrackerStaticField.instance;
        assertThat(trackerEnum1, is(trackerEnum2));
    }

    @Test
    public void testTrackerStaticFinalField() {
        TrackerStaticFinalField trackerEnum1 = TrackerStaticFinalField.getInstance();
        TrackerStaticFinalField trackerEnum2 = TrackerStaticFinalField.getInstance();
        assertThat(trackerEnum1, is(trackerEnum2));
    }

    @Test
    public void testTrackerStaticFinalClass() {
        TrackerStaticFinalClass trackerEnum1 = TrackerStaticFinalClass.getInstance();
        TrackerStaticFinalClass trackerEnum2 = TrackerStaticFinalClass.getInstance();
        assertThat(trackerEnum1, is(trackerEnum2));
    }


}
