#Rechnerarchitektur Übungsblatt 1
##Aufgabe 3
i) 
```
Diskette
1509950 Bit
188743.75 Byte
184.32 KB
0.18 MB
0.00 GB
0.00 TB

USB-Stick
2147483648 Bit
268435456.00 Byte
262144.00 KB
256.00 MB
0.25 GB
0.00 TB

CD
5872025600 Bit
734003200.00 Byte
716800.00 KB
700.00 MB
0.68 GB
0.00 TB

BluRay
429496729600 Bit
53687091200.00 Byte
52428800.00 KB
51200.00 MB
50.00 GB
0.05 TB

Festplatte 250GB
2147483648000 Bit
268435456000.00 Byte
262144000.00 KB
256000.00 MB
250.00 GB
0.24 TB

Festplatte 1TB
8796093022208 Bit
1099511627776.00 Byte
1073741824.00 KB
1048576.00 MB
1024.00 GB
1.00 TB

```
b.
Als Größenangabe nicht sinnvoll. Wird aber benötigt bei der genauen Addressierung des Speichers. Hier benötigt man bit-genaue Angaben.


##Aufgabe 2

`` (21cm * 29,7cm)*(0,393700787 Zoll/cm)^2 * (1200 px/Zoll)^2 = 139210118 px``

`` 139210118 * 8Bit * 3 = 3341042832 Bit ``

`` 2320.17b / 1048576b/Mbit = 3186,3Mbit``

WLAN: ``3186,3Mbit / 600Mbit/s = 5,3s``

Ethernet: `` 3186,3Mbit / 1024Mb/s = 3,1Gbit/s ``

b.
i

2^13 < 21 * 0,393700787 * 1200 = 9921,3 < 16384 = 2^14
29 * 0,393700787 * 1200  < 16384 = 2^14

-> 14 Bits pro Richtung -> 28 Bits für Koordinaten

ii
100 * 45 * 60 * (16 + 28) = 11880000 [Bits]

11880000Bits / 1048576bit/Mbit = 11,3 Mbit

WLan: 11,3 / 600 = 0,019 [s]
Ethernet: 11,3 / 1024 = 0,011 [s]



##Aufgabe 5

a: `f`
b: `r`
c: `f`
d: `r`
e: `f`