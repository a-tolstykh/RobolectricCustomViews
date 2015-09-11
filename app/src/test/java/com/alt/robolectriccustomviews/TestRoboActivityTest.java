package com.alt.robolectriccustomviews;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

// Robolectric supports only SDK 21- so we need emulate it.
// Also now gradle and Android Studio JUnit test runner run tests from different working
// directories so we need to specify Android manifest location implicitly.
// WARNING: Application uses flavors, so implicit manifest location could break tests.
// WARNING: In case of any problem with configuring path to Manifest (Mac users) see - https://github.com/robolectric/robolectric/wiki/Running-tests-in-Android-Studio
@Config(
        sdk = 21,
        manifest = "src/main/AndroidManifest.xml",
        constants = BuildConfig.class
)
@RunWith(RobolectricTestRunner.class)
public class TestRoboActivityTest {
    private TestRoboActivity mActivity;

    @Before
    public void setUp() throws Exception {
        mActivity = Robolectric.buildActivity(TestRoboActivity.class).create().get();
    }

    @After
    public void tearDown() throws Exception {
        mActivity = null;
    }

    @Test
    public void testSanity() throws Exception {
        Assert.assertNotNull(mActivity);
    }
}
