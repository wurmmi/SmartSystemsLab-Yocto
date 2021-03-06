SUMMARY = "A minimal system image for the DE1-SoC"
LICENSE = "CLOSED"

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

inherit core-image

# auto create image for sdcard
# other options ext4 tar.gz
IMAGE_FSTYPES = "wic"

# extend rootfs partition size
IMAGE_ROOTFS_EXTRA_SPACE = "128000"

#
# Extra image configuration defaults
#
# The EXTRA_IMAGE_FEATURES variable allows extra packages to be added to the generated
# images. Some of these options are added to certain image types automatically. The
# variable can contain the following options:
#  "dbg-pkgs"       - add -dbg packages for all installed packages
#                     (adds symbol information for debugging/profiling)
#  "dev-pkgs"       - add -dev packages for all installed packages
#                     (useful if you want to develop against libs in the image)
#  "ptest-pkgs"     - add -ptest packages for all ptest-enabled packages
#                     (useful if you want to run the package test suites)
#  "tools-sdk"      - add development tools (gcc, make, pkgconfig etc.)
#  "tools-debug"    - add debugging tools (gdb, strace)
#  "eclipse-debug"  - add Eclipse remote debugging support
#  "tools-profile"  - add profiling tools (oprofile, lttng, valgrind)
#  "tools-testapps" - add useful testing tools (ts_print, aplay, arecord etc.)
#  "debug-tweaks"   - make an image suitable for development
#                     e.g. ssh root access has a blank password
# There are other application targets that can be used here too, see
# meta/classes/image.bbclass and meta/classes/core-image.bbclass for more details.
# We default to enabling the debugging tweaks.
EXTRA_IMAGE_FEATURES = "debug-tweaks tools-debug debug-tweaks ssh-server-openssh package-management"


# configure package feeds for apt
PACKAGE_FEED_URIS = "http://192.168.1.100:8080"

# applications and kernel drivers
IMAGE_INSTALL += "mpu9250-mod"
IMAGE_INSTALL += "apds9301-mod"
IMAGE_INSTALL += "sevensegment-mod"
IMAGE_INSTALL += "hdc1000-mod"
#IMAGE_INSTALL += "sensorplatform"
#IMAGE_INSTALL += "iiotapp"
#IMAGE_INSTALL += "managementif"
IMAGE_INSTALL += "show-ip"
IMAGE_INSTALL += "hdc1000"
IMAGE_INSTALL += "streaming-sensors"
IMAGE_INSTALL += "event-sensors"
IMAGE_INSTALL += "debugservice"
IMAGE_INSTALL += "debugif"
IMAGE_INSTALL += "sensorplatform"


# libraries
IMAGE_INSTALL += "libwebsockets"
IMAGE_INSTALL += "poco"
IMAGE_INSTALL += "paho-mqtt-c"
IMAGE_INSTALL += "paho-mqtt-cpp"
# gpio chardev lib
IMAGE_INSTALL += "libgpiod"
IMAGE_INSTALL += "zlib"

# include static lib and headerfiles in sdk
TOOLCHAIN_TARGET_TASK += "libfpgaregion-dev libfpgaregion-staticdev"
TOOLCHAIN_TARGET_TASK += "libwebsockets-dev"
TOOLCHAIN_TARGET_TASK += "poco-dev"

# additional software
IMAGE_INSTALL += "htop"
IMAGE_INSTALL += "bash"
IMAGE_INSTALL += "gdbserver"
IMAGE_INSTALL += "dhcp-client"
IMAGE_INSTALL += "tzdata"
IMAGE_INSTALL += "ntp"
IMAGE_INSTALL += "screen"
IMAGE_INSTALL += "nginx"
IMAGE_INSTALL += "coreutils"
IMAGE_INSTALL += "dtc"
IMAGE_INSTALL += "nano"
IMAGE_INSTALL += "hdparm"
IMAGE_INSTALL += "wget"
# for pkill
IMAGE_INSTALL += "procps"
IMAGE_INSTALL += "iftop"
#IMAGE_INSTALL += "sysbench"
#IMAGE_INSTALL += "dhrystone"
# for mpstat
IMAGE_INSTALL += "sysstat"
# test key events
IMAGE_INSTALL += "evtest"

# enable sftp for sshd
IMAGE_INSTALL += "openssh-sftp"
IMAGE_INSTALL += "openssh-misc"
IMAGE_INSTALL += "openssh-sftp-server"

# package management
IMAGE_INSTALL += "apt"
IMAGE_INSTALL += "gnupg"

# keymaps bindings in /usr/share
IMAGE_INSTALL += "kbd"
IMAGE_INSTALL += "kbd-keymaps"
IMAGE_INSTALL += "gettext"
IMAGE_INSTALL += "ncurses"
IMAGE_INSTALL += "readline"

# dns resolving
IMAGE_INSTALL += "resolvconf"

# others
#IMAGE_INSTALL += "autofs"
#IMAGE_INSTALL += "iperf3"
