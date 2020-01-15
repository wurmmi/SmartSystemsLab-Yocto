DESCRIPTION = "Application which reads data from all provided sensors and forwards them to the cloud. Additionally the value of the ambient light sensor is used to dimm the seven segment display"
LICENSE = "CLOSED"

DEPENDS += "paho-mqtt-c paho-mqtt-cpp libfpgaregion"
RDEPENDS_${PN} += "paho-mqtt-c paho-mqtt-cpp"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/skaupper/SmartSystemsLab.git;protocol=http;branch=master"

S = "${WORKDIR}/git/user/streaming_sensors"

TARGET_CC_ARCH += "${LDFLAGS}"

do_install() {
    install -m 0755 -d ${D}${bindir}
    install -m 0755 ${S}/streaming_sensors ${D}${bindir}/
}

FILES_${PN} = "${bindir}/streaming_sensors"
