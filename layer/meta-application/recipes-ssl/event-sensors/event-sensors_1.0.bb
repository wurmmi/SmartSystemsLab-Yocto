DESCRIPTION = "Application which reads data from all provided sensors and forwards them to the cloud. Additionally the value of the ambient light sensor is used to dimm the seven segment display"
LICENSE = "CLOSED"
FILESEXTRAPATHS_prepend := "${THISDIR}/files/:"

DEPENDS += "paho-mqtt-c paho-mqtt-cpp libfpgaregion zlib"
RDEPENDS_${PN} += "paho-mqtt-c paho-mqtt-cpp"

SRCREV = "${AUTOREV}"
SRC_URI = "git://github.com/skaupper/SmartSystemsLab.git;protocol=http;branch=master"
SRC_URI += "file://event_sensors.service"
SRC_URI += "file://event_sensors.timer"


S = "${WORKDIR}/git/user/event_sensors"

TARGET_CC_ARCH += "${LDFLAGS}"


inherit systemd
SYSTEMD_SERVICE_${PN} = "event_sensors.timer"


do_install() {
    # install TLS certificate
    install -d ${D}/${sysconfdir}/SmartSystemsLab
    install -c -m 0644 ${S}/ca.crt ${D}/${sysconfdir}/SmartSystemsLab

	# install service file
    install -d ${D}${systemd_system_unitdir}
    install -c -m 0644 ${WORKDIR}/event_sensors.service ${D}${systemd_system_unitdir}
    install -c -m 0644 ${WORKDIR}/event_sensors.timer ${D}${systemd_system_unitdir}

    # install binary
    install -m 0755 -d ${D}${bindir}
    install -m 0755 ${S}/event_sensors ${D}${bindir}
}

FILES_${PN} = "${systemd_system_unitdir}/event_sensors.service"
FILES_${PN} += "${systemd_system_unitdir}/event_sensors.timer"
FILES_${PN} += "${bindir}/event_sensors"
FILES_${PN} += "${sysconfdir}/event_sensors"
FILES_${PN} += "${base_libdir}/firmware"
FILES_${PN} += "${sysconfdir}/SmartSystemsLab"
