DESCRIPTION = "Driver for the MPU9250 sensor"
LICENSE = "CLOSED"

inherit module

SRCREV  = "${AUTOREV}"
SRC_URI = "git://github.com/skaupper/SmartSystemsLab.git;protocol=http;branch=master"

S = "${WORKDIR}/git/drivers/mpu9250"
KERNEL_MODULE_AUTOLOAD += "mpu9250"
