DESCRIPTION = "Driver for the seven segment display"
LICENSE = "CLOSED"

inherit module

SRCREV  = "48f29fc25788cb89140c6bbc2e2fb410c7a4f54b"
SRC_URI = "git://git@github.com/skaupper/SmartSystemsLab.git;protocol=ssh;branch=master"

S = "${WORKDIR}/git/drivers/sevensegment"
KERNEL_MODULE_AUTOLOAD += "sevensegment"
