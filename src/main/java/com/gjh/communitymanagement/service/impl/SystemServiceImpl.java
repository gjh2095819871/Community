package com.gjh.communitymanagement.service.impl;

import com.gjh.communitymanagement.service.SystemService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.InetAddress;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Properties;

/**
 * @Author guojianhui
 * @ClassName: SystemServiceImpl
 * @Version 1.0
 */
@Service
public class SystemServiceImpl implements SystemService {
    @Override
    public Map<String, String> get() {
        try {
            InetAddress ip = InetAddress.getLocalHost();
            String localName = ip.getHostName();
            Properties props = System.getProperties();
            String osName = System.getProperty("os.name");
            String userName = System.getProperty("user.name");
            String osVersion = System.getProperty("os.version");
            String osArch = System.getProperty("os.arch");

            System.out.println("当前用户：" + userName);
            System.out.println("用户的当前工作目录：" + props.getProperty("user.dir"));
            System.out.println(ip.getHostAddress());
            System.out.println("主机名称：" + localName);
            System.out.println("主机系统：" + osName);
            System.out.println("系统架构：" + osArch);



            // 统计总内存
            long total = 0;
            // 统计总空闲
            long free = 0;
            // 统计总可用
            long usable = 0;
            // 统计总已用
            long used = 0;
            // 磁盘总使用
            double usedRate = 0.0;

            int RADIX = 1024;
            File[] disks = File.listRoots();
            for (File file : disks) {
                // 统计总量
                total += file.getTotalSpace();
                free += file.getFreeSpace();
                usable += file.getUsableSpace();
                used += file.getTotalSpace() - file.getFreeSpace();
            }

            String rootPath = "/";
            usedRate = used * 1.0 / total;

            System.out.println("磁盘根路径：" + rootPath);
            System.out.println("主机总共空间：" + new DecimalFormat("#.##").format(total * 1.0 / Math.pow(RADIX, 3)) + "G");
            System.out.println("主机总空闲空间：" + new DecimalFormat("#.##").format(free * 1.0 / Math.pow(RADIX, 3)) + "G");
            System.out.println("主机总可用空间：" + new DecimalFormat("#.##").format(usable * 1.0 / Math.pow(RADIX, 3)) + "G");
            System.out.println("主机总已用空间：" + new DecimalFormat("#.##").format(used * 1.0 / Math.pow(RADIX, 3)) + "G");
            System.out.println("主机总使用率：" + new DecimalFormat("#.##%").format(usedRate));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
