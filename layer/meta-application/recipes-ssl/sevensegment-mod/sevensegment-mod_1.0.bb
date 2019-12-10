DESCRIPTION = "Driver for the seven segment display"
LICENSE = "CLOSED"

inherit module

SRCREV  = "${AUTOREV}"
SRC_URI = "git://github.com/skaupper/SmartSystemsLab.git;protocol=http;branch=master"

S = "${WORKDIR}/git/drivers/sevensegment"
KERNEL_MODULE_AUTOLOAD += "sevensegment"
