package ru.stqa.pft.soap;

import org.testng.Assert;
import org.testng.annotations.Test;
import wsdl2java.f3d32a0b14d5363f78f991598ca9c0b8.com.lavasoft.GeoIPService;

import static org.testng.Assert.assertEquals;

public class GeoIpServiceTests {
    @Test
    public void testMyIp(){
        String ipLocation20 = new GeoIPService().getGeoIPServiceSoap12().getIpLocation20("185.224.10.86");
        System.out.println(ipLocation20);

    }
    @Test
    public void testInvalidIp() {
        String ipLocation20 = new GeoIPService().getGeoIPServiceSoap12().getIpLocation20("109.252.76.xxx");
        System.out.println(ipLocation20);

    }
}
