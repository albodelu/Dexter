 #!/bin/sh

./gradlew :sample:uninstallAll spoon -PspoonClassName=com.karumi.dexter.sample.SampleActivityTest -PspoonMethodName=onGrantCameraPermissionThenFeedbackTextShowsItsGranted
./gradlew :sample:uninstallAll spoon -PspoonClassName=com.karumi.dexter.sample.SampleActivityTest -PspoonMethodName=onDenyCameraPermissionThenFeedbackTextShowsItsDenied
