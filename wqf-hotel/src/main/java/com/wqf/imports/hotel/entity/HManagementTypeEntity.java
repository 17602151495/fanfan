package com.wqf.imports.hotel.entity;

        import java.io.Serializable;
        import java.util.Date;


/**
 * 
 *
 * @author lzh
 * @email 623389761@gmail.com
 * @date 2019-04-17 00:33:22
 */
public class HManagementTypeEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	        //
        private Long id;
	        //经营类型名字
        private String tyname;
	        //上级ID
        private Long pid;
	
	        /**
         * 设置：
         */
        public void setId(Long id) {
            this.id = id;
        }
        /**
         * 获取：
         */
        public Long getId() {
            return id;
        }
	        /**
         * 设置：经营类型名字
         */
        public void setTyname(String tyname) {
            this.tyname = tyname;
        }
        /**
         * 获取：经营类型名字
         */
        public String getTyname() {
            return tyname;
        }
	        /**
         * 设置：上级ID
         */
        public void setPid(Long pid) {
            this.pid = pid;
        }
        /**
         * 获取：上级ID
         */
        public Long getPid() {
            return pid;
        }
	}