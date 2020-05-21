package com.ljr.study.ui;

import android.app.Activity;
import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.EditorAction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.rule.ActivityTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.ljr.study.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MIActivityTest {
    @Rule
    ActivityTestRule<MIActivity> mRule = new ActivityTestRule<MIActivity>(MIActivity.class);

    private Activity mActivity;

    @Before
    public void setUp() throws Exception {
        mActivity = mRule.getActivity();
    }

    @Test
    public void test() {
        Espresso.onView(ViewMatchers.withId(R.id.main_recycler_view)).perform()
    }

    @After
    public void tearDown() throws Exception {
    }

}