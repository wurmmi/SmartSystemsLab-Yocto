DESCRIPTION = "Test application which displays the IP on the seven segment display"
LICENSE = "CLOSED"

SRCREV = "48f29fc25788cb89140c6bbc2e2fb410c7a4f54b"
SRC_URI = "git://github.com/skaupper/SmartSystemsLab.git;protocol=http;branch=master"

S = "${WORKDIR}/git/user/show_ip"

TARGET_CC_ARCH += "${LDFLAGS}"

do_install() {
    install -m 0755 -d ${D}${bindir}
    install -m 0755 ${S}/show_ip ${D}${bindir}/
}
