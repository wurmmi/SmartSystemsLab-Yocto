DESCRIPTION = "Application which reads data from the kernel module and sends it to the cloud"
LICENSE = "CLOSED"

DEPENDS += "paho-mqtt-c paho-mqtt-cpp"
RDEPENDS_${PN} += "paho-mqtt-c paho-mqtt-cpp"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/skaupper/SmartSystemsLab.git;protocol=http;branch=skaupper/hdc1000-app"

S = "${WORKDIR}/git/user/hdc1000"

TARGET_CC_ARCH += "${LDFLAGS}"

do_install() {
    install -m 0755 -d ${D}${bindir}
    install -m 0755 ${S}/hdc1000 ${D}${bindir}/
}
