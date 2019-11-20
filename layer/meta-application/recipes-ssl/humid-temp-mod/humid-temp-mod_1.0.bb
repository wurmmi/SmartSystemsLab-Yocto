DESCRIPTION = "Driver for the HDC1000 sensor"
LICENSE = "CLOSED"

inherit module

SRCREV  = "fb4c060d1548969c3c5e052272d590d8e3895cfd"
SRC_URI = "git://github.com/skaupper/SmartSystemsLab.git;protocol=http;branch=wurmmi/humid_temp"

S = "${WORKDIR}/git/drivers/humid_temp"
KERNEL_MODULE_AUTOLOAD += "humid_temp"
