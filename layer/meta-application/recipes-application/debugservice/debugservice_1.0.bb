DESCRIPTION = "IIoT App"
SECTION = "base"
LICENSE = "CLOSED"
FILESEXTRAPATHS_prepend := "${THISDIR}/files/:"

SRC_URI = "git://gitlab.fh-ooe.at/smart_systems_lab/debug_service.git;protocol=https;user=gitlab+deploy-token-5:QbxxCZf4MsTZxr9dnAkZ;branch=master"
SRCREV = "${AUTOREV}"

SRC_URI += "file://debugservice.service"

SYSTEMD_SERVICE_${PN} = "debugservice.service"

DEPENDS = "systemd"
RDEPENDS_${PN} = "systemd poco-net poco-util poco-foundation poco-json libssl libcrypto libgpiod"

inherit systemd

GIT = "${WORKDIR}/git/"

do_install() {
    # install service file
    install -d ${D}${systemd_unitdir}/system
    install -c -m 0644 ${WORKDIR}/debugservice.service ${D}${systemd_unitdir}/system

    # install binary
    install -d ${D}${bindir}
    install -c -m 0755 ${GIT}/VisualGDB/Release/DebugService ${D}${bindir}/debugservice

    # install empty firmware dir if not existing to store fpga bitfile
    install -d -m 0755 ${D}${base_libdir}/firmware

    # install config
    install -d ${D}${sysconfdir}/debugservice
}

FILES_${PN} = "${base_libdir}/systemd/system/debugservice.service"
FILES_${PN} += "${bindir}/debugservice"
FILES_${PN} += "${sysconfdir}/debugservice"
FILES_${PN} += "${base_libdir}/firmware"

# As this package is tied to systemd, only build it when we're also building systemd.
python () {
    if not bb.utils.contains ('DISTRO_FEATURES', 'systemd', True, False, d):
        raise bb.parse.SkipPackage("'systemd' not in DISTRO_FEATURES")
}
