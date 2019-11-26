DESCRIPTION = "Driver for the HDC1000 sensor"
LICENSE = "CLOSED"

inherit module

SRCREV  = "${AUTOREV}"
SRC_URI = "git://github.com/skaupper/SmartSystemsLab.git;protocol=http;branch=master"

S = "${WORKDIR}/git/drivers/humid_temp"
KERNEL_MODULE_AUTOLOAD += "humid_temp"
