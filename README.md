# Yocto Image for Project SoC

Example project for the Terasic DE1-SoC development board.

The purpose of this repository is to provide a full Linux image for an example application.
The image further includes several required files, such as the FPGA image, kernel drivers, as well as user-space applications.

### Features

- Embedded Linux
- Linux user-space firmware
- FPGA Design

### How to run

1. Initialize the cross-compile environment for bitbake. \
   `source environmentinit`
2. Build the image.\
   `bitbake core-image-ssl`
3. The image is created at `TMPDIR/deploy/images/cyclone5/core-image-ssl-cyclone5.wic`.\
   TMPDIR is defined in the conf/local.conf file.
4. Flash this file onto an SD Card. A bootable disk is created.

Make sure to check out submodules by running `git submodule update --init --recursive`.

### Contact
Michael Wurm <<wurm.michael95@gmail.com>>
