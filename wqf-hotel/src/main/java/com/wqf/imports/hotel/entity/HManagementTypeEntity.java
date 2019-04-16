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
        private Integer id;
	        //经营类型名字
        private String tyname;
	        //上级ID
        private Integer pid;
	
	        /**
         * 设置：
         */
        public void setId(Integer id) {
            this.id = id;
        }
        /**
         * 获取：
         */
        public Integer getId() {
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
        public void setPid(Integer pid) {
            this.pid = pid;
        }
        /**
         * 获取：上级ID
         */
        public Integer getPid() {
            return pid;
        }
	}