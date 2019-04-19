package com.wqf.imports.hotel.entity;

        import java.io.Serializable;
        import java.util.Date;


/**
 * 
 *
 * @author lzh
 * @email 623389761@gmail.com
 * @date 2019-04-19 00:28:15
 */
public class HotelEntity implements Serializable {
    private static final long serialVersionUID = 1L;

	        //
        private Long id;
	        //店长ID
        private Long userid;
	        //店铺名字
        private String name;
	        //联系电话
        private String tel;
	        //店铺图片
        private String hotelpic;
	        //店铺介绍
        private String introduce;
	        //营业开始时间
        private Date startime;
	        //营业结束时间
        private Date endtime;
	        //省
        private String province;
	        //市
        private String city;
	        //县区
        private String county;
	        //详细地址
        private String address;
	        //经度
        private String longitude;
	        //纬度
        private String latitude;
	        //店铺分类（1饭店 2 酒店 3快餐店 4 食堂）
        private Integer classification;
	        //经营类型（1烧烤香锅 2 休闲茶饮 3中餐地方 3.1 鲁菜）
        private Integer mtype;
	        //级别 1 总店 2 分店 3 连锁店
        private Integer level;
	        //经营状态（1营业中 2 暂停营业 3即将开业）
        private Integer mstate;
	        //店铺状态 （正常 ，下线，欠费,违规） 
        private Integer sta;
	        //
        private Date createTime;
	        //
        private Date updateTime;
	        //
        private Long createby;
	        //
        private Long updateby;
	
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
         * 设置：店长ID
         */
        public void setUserid(Long userid) {
            this.userid = userid;
        }
        /**
         * 获取：店长ID
         */
        public Long getUserid() {
            return userid;
        }
	        /**
         * 设置：店铺名字
         */
        public void setName(String name) {
            this.name = name;
        }
        /**
         * 获取：店铺名字
         */
        public String getName() {
            return name;
        }
	        /**
         * 设置：联系电话
         */
        public void setTel(String tel) {
            this.tel = tel;
        }
        /**
         * 获取：联系电话
         */
        public String getTel() {
            return tel;
        }
	        /**
         * 设置：店铺图片
         */
        public void setHotelpic(String hotelpic) {
            this.hotelpic = hotelpic;
        }
        /**
         * 获取：店铺图片
         */
        public String getHotelpic() {
            return hotelpic;
        }
	        /**
         * 设置：店铺介绍
         */
        public void setIntroduce(String introduce) {
            this.introduce = introduce;
        }
        /**
         * 获取：店铺介绍
         */
        public String getIntroduce() {
            return introduce;
        }
	        /**
         * 设置：营业开始时间
         */
        public void setStartime(Date startime) {
            this.startime = startime;
        }
        /**
         * 获取：营业开始时间
         */
        public Date getStartime() {
            return startime;
        }
	        /**
         * 设置：营业结束时间
         */
        public void setEndtime(Date endtime) {
            this.endtime = endtime;
        }
        /**
         * 获取：营业结束时间
         */
        public Date getEndtime() {
            return endtime;
        }
	        /**
         * 设置：省
         */
        public void setProvince(String province) {
            this.province = province;
        }
        /**
         * 获取：省
         */
        public String getProvince() {
            return province;
        }
	        /**
         * 设置：市
         */
        public void setCity(String city) {
            this.city = city;
        }
        /**
         * 获取：市
         */
        public String getCity() {
            return city;
        }
	        /**
         * 设置：县区
         */
        public void setCounty(String county) {
            this.county = county;
        }
        /**
         * 获取：县区
         */
        public String getCounty() {
            return county;
        }
	        /**
         * 设置：详细地址
         */
        public void setAddress(String address) {
            this.address = address;
        }
        /**
         * 获取：详细地址
         */
        public String getAddress() {
            return address;
        }
	        /**
         * 设置：经度
         */
        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }
        /**
         * 获取：经度
         */
        public String getLongitude() {
            return longitude;
        }
	        /**
         * 设置：纬度
         */
        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }
        /**
         * 获取：纬度
         */
        public String getLatitude() {
            return latitude;
        }
	        /**
         * 设置：店铺分类（1饭店 2 酒店 3快餐店 4 食堂）
         */
        public void setClassification(Integer classification) {
            this.classification = classification;
        }
        /**
         * 获取：店铺分类（1饭店 2 酒店 3快餐店 4 食堂）
         */
        public Integer getClassification() {
            return classification;
        }
	        /**
         * 设置：经营类型（1烧烤香锅 2 休闲茶饮 3中餐地方 3.1 鲁菜）
         */
        public void setMtype(Integer mtype) {
            this.mtype = mtype;
        }
        /**
         * 获取：经营类型（1烧烤香锅 2 休闲茶饮 3中餐地方 3.1 鲁菜）
         */
        public Integer getMtype() {
            return mtype;
        }
	        /**
         * 设置：级别 1 总店 2 分店 3 连锁店
         */
        public void setLevel(Integer level) {
            this.level = level;
        }
        /**
         * 获取：级别 1 总店 2 分店 3 连锁店
         */
        public Integer getLevel() {
            return level;
        }
	        /**
         * 设置：经营状态（1营业中 2 暂停营业 3即将开业）
         */
        public void setMstate(Integer mstate) {
            this.mstate = mstate;
        }
        /**
         * 获取：经营状态（1营业中 2 暂停营业 3即将开业）
         */
        public Integer getMstate() {
            return mstate;
        }
	        /**
         * 设置：店铺状态 （正常 ，下线，欠费,违规） 
         */
        public void setSta(Integer sta) {
            this.sta = sta;
        }
        /**
         * 获取：店铺状态 （正常 ，下线，欠费,违规） 
         */
        public Integer getSta() {
            return sta;
        }
	        /**
         * 设置：
         */
        public void setCreateTime(Date createTime) {
            this.createTime = createTime;
        }
        /**
         * 获取：
         */
        public Date getCreateTime() {
            return createTime;
        }
	        /**
         * 设置：
         */
        public void setUpdateTime(Date updateTime) {
            this.updateTime = updateTime;
        }
        /**
         * 获取：
         */
        public Date getUpdateTime() {
            return updateTime;
        }
	        /**
         * 设置：
         */
        public void setCreateby(Long createby) {
            this.createby = createby;
        }
        /**
         * 获取：
         */
        public Long getCreateby() {
            return createby;
        }
	        /**
         * 设置：
         */
        public void setUpdateby(Long updateby) {
            this.updateby = updateby;
        }
        /**
         * 获取：
         */
        public Long getUpdateby() {
            return updateby;
        }
	}