DESCRIPTION = "Application which reads data from all provided sensors and forwards them to the cloud. Additionally the value of the ambient light sensor is used to dimm the seven segment display"
LICENSE = "CLOSED"
FILESEXTRAPATHS_prepend := "${THISDIR}/files/:"

DEPENDS += "paho-mqtt-c paho-mqtt-cpp libfpgaregion"
RDEPENDS_${PN} += "paho-mqtt-c paho-mqtt-cpp"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/skaupper/SmartSystemsLab.git;protocol=http;branch=master"
SRC_URI += "file://event_sensors.service"

S = "${WORKDIR}/git/user/event_sensors"

TARGET_CC_ARCH += "${LDFLAGS}"

inherit systemd

do_install() {
	# install service file
    install -d ${D}${systemd_unitdir}/system
    install -c -m 0644 ${WORKDIR}/event_sensors.service ${D}${systemd_unitdir}/system
	
    install -m 0755 -d ${D}${bindir}
    install -m 0755 ${S}/event_sensors ${D}${bindir}/
}

FILES_${PN} = "${base_libdir}/systemd/system/event-sensors.service"
FILES_${PN} += "${bindir}/event_sensors"
FILES_${PN} += "${sysconfdir}/event_sensors"
FILES_${PN} += "${base_libdir}/firmware"