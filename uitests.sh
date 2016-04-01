 #!/bin/sh

./gradlew :sample:uninstallAll spoon -PspoonClassName=com.karumi.dexter.sample.SampleActivityTest -PspoonMethodName=onGrantPermissionOnBackgroundThreadThenPermissionIsGranted
./gradlew :sample:uninstallAll spoon -PspoonClassName=com.karumi.dexter.sample.SampleActivityTest -PspoonMethodName=onDenyPermissionOnBackgroundThreadThenPermissionIsDenied
./gradlew :sample:uninstallAll spoon -PspoonClassName=com.karumi.dexter.sample.SampleActivityTest -PspoonMethodName=onGrantPermissionOnMainThreadThenPermissionIsGranted
./gradlew :sample:uninstallAll spoon -PspoonClassName=com.karumi.dexter.sample.SampleActivityTest -PspoonMethodName=onDenyPermissionOnMainThreadThenPermissionIsDenied
./gradlew :sample:uninstallAll spoon -PspoonClassName=com.karumi.dexter.sample.SampleActivityTest -PspoonMethodName=onDenyPermissionThenRationaleIsShownInNextRequest
./gradlew :sample:uninstallAll spoon -PspoonClassName=com.karumi.dexter.sample.SampleActivityTest -PspoonMethodName=onRotateDeviceWhileRequestingPermissionThenPermissionIsStillRequested
