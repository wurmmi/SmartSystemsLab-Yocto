SUMMARY = "Bitfile to configure FPGA"
LICENSE = "CLOSED"

RDEPENDS_${PN} += "paho-mqtt-c paho-mqtt-cpp"


SRC_URI = "git://github.com/skaupper/SmartSystemsLab.git;protocol=http;branch=master"

SRCREV = "${AUTOREV}"

DEPENDS += "dtc-native"

OUTPUT = "${WORKDIR}/git/artifacts/MS3"

do_configure() {
	dtc -I "dts" -O "dtb" -o ${WORKDIR}/socfpga.dtbo ${OUTPUT}/socfpga.dtso
}

do_install() {
	install -d -m 0755 ${D}${base_libdir}/firmware
	
	install -m 0666 ${OUTPUT}/socfpga.rbf ${D}${base_libdir}/firmware/socfpga.rbf
	install -m 0666 ${WORKDIR}/socfpga.dtbo ${D}${base_libdir}/firmware/socfpga.dtbo
}

FILES_${PN} += "${base_libdir}/firmware"
