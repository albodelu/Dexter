/*
 * Copyright (C) 2016 Karumi.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.karumi.dexter.sample;

import android.content.Context;
import android.content.Intent;
import android.support.test.runner.AndroidJUnit4;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.InstrumentationRegistry.getTargetContext;

@RunWith(AndroidJUnit4.class) public class SampleActivityTest {

  private static final String PACKAGE = "com.karumi.dexter.sample";
  private UiDevice device;

  @Before public void setUp() throws Exception {
    device = UiDevice.getInstance(getInstrumentation());
    Context context = getTargetContext();
    final Intent intent = context.getPackageManager().getLaunchIntentForPackage(PACKAGE);
    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
    context.startActivity(intent);
    device.wait(Until.hasObject(By.pkg(PACKAGE).depth(0)), 5000);
  }

  @Test public void onGrantCameraPermissionThenFeedbackTextShowsItsGranted() throws Exception {
    whenCameraButtonIsClicked();
    whenCameraPermissionIsGranted();

    thenCameraFeedbackShowsPermissionGranted();
  }

  @Test public void onDenyCameraPermissionThenFeedbackTextShowsItsDenied() throws Exception {
    whenCameraButtonIsClicked();
    whenCameraPermissionIsDenied();

    thenCameraFeedbackShowsPermissionDenied();
  }

  private void whenCameraButtonIsClicked() throws UiObjectNotFoundException {
    device.findObject(getSelectorWithText(R.string.ask_for_camera_permission_button)).click();
  }

  private void whenCameraPermissionIsGranted() throws Exception {
    device.findObject(new UiSelector().text("Allow")).click();
  }

  private void whenCameraPermissionIsDenied() throws Exception {
    device.findObject(new UiSelector().text("Deny")).click();
  }

  private void thenCameraFeedbackShowsPermissionGranted() throws UiObjectNotFoundException {
    device.findObject(getSelectorWithText(R.string.permission_granted_feedback));
  }

  private void thenCameraFeedbackShowsPermissionDenied() throws UiObjectNotFoundException {
    device.findObject(getSelectorWithText(R.string.permission_denied_feedback));
  }

  private UiSelector getSelectorWithText(int resId) {
    return new UiSelector().text(getString(resId));
  }

  private String getString(int resId) {
    return getTargetContext().getString(resId);
  }
}
