package com.gjh.communitymanagement.service.impl;

import com.gjh.communitymanagement.service.SystemService;
import org.springframework.stereotype.Service;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.net.InetAddress;
import java.security.Principal;
import java.text.DecimalFormat;
import java.util.*;

/**
 * @Author guojianhui
 * @ClassName: SystemServiceImpl
 * @Version 1.0
 */
@Service
public class SystemServiceImpl implements SystemService {
    @Override
    public Map<String, String> get() {
        HashMap<String, String> map = new HashMap<>();
        try {
            InetAddress ip = InetAddress.getLocalHost();
            Properties props = System.getProperties();

            map.put("userName",System.getProperty("user.name"));
            map.put("userdir",props.getProperty("user.dir"));
            map.put("ip",ip.getHostAddress());
            map.put("localName",ip.getHostName());
            map.put("osName" ,System.getProperty("os.name"));
            map.put("osArch" ,System.getProperty("os.arch"));

            // 统计总内存
            long total = 0;
            // 统计总已用
            long used = 0;
            // 磁盘总使用
            double usedRate = 0.0;

            int RADIX = 1024;
            File[] disks = File.listRoots();
            for (File file : disks) {
                // 统计总量
                total += file.getTotalSpace();
                used += file.getTotalSpace() - file.getFreeSpace();
            }

            usedRate = used * 1.0 / total;

            map.put("totalused",new DecimalFormat("#.##").format(total * 1.0 / Math.pow(RADIX, 3)) + "/"
            + new DecimalFormat("#.##").format(used * 1.0 / Math.pow(RADIX, 3)) + "G"
            );
            map.put("usedRate",new DecimalFormat("#.##%").format(usedRate));
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }
}
