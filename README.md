# Community
小区管理系统
![image](https://user-images.githubusercontent.com/65147786/227552976-b46dca71-be9c-4b83-9e07-bb6a45085a99.png)
nginx配置：
  ```  
  server {
        listen       80;
        server_name  www.community.com;
        proxy_set_header X-Forwarded-Host $host;
		proxy_set_header X-Forwarded-Server $host;
		proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;
		location /image{
			alias D:/spring-project/code/Community/src/main/resources/static;
			break;
		}
		location / {
			proxy_pass http://127.0.0.1:8081;
			proxy_connect_timeout 600;
			proxy_read_timeout 600;
		}
    }
    ```
host配置：
    ```
    127.0.0.1 www.community.com
    ```

项目启动后访问  www.community.com
