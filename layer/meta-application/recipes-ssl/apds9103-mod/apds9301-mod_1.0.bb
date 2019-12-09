DESCRIPTION = "Driver for the APDS9301 sensor"
LICENSE = "CLOSED"

inherit module

SRCREV  = "${AUTOREV}"
SRC_URI = "git://github.com/skaupper/SmartSystemsLab.git;protocol=http;branch=wurmmi/apds9301"

S = "${WORKDIR}/git/drivers/apds9301"
KERNEL_MODULE_AUTOLOAD += "apds9301"
