package sng.com.showme.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by son.nguyen on 4/18/2016.
 */
public class UserSession {
    private static UserSession sUserSession;

    private UserSession() {
        sUserSession = this;
    }

    public static UserSession getInstance() {
        if (sUserSession == null) {
            sUserSession = new UserSession();
        }
        return sUserSession;
    }

    public static void setUserSession(UserSession userSession) {
        sUserSession = userSession;
        if (userSession.getAddress()!=null){
            sUserSession.setAddress(userSession.getAddress());
        }
        if(userSession.getAvatar()!=null){
            sUserSession.setAvatar(userSession.getAvatar());
        }
        if(userSession.getCountry()!=null){
            sUserSession.setCountry(userSession.getCountry());
        }
        if (userSession.getCreateDate()!=null){
            sUserSession.setCreateDate(userSession.getCreateDate());
        }
        if(userSession.getUserId()!=null){
            sUserSession.setUserId(userSession.getUserId());
        }
        if(userSession.getUserName()!=null){
            sUserSession.setUserName(userSession.getUserName());
        }
        if(userSession.getFirstname()!=null){
            sUserSession.setFirstname(userSession.getFirstname());
        }
        if(userSession.getLastname()!=null){
            sUserSession.setLastname(userSession.getLastname() );
        }
        if(userSession.getDob()!=null){
            sUserSession.setDob(userSession.getDob());
        }
        if(userSession.getEmail()!=null){
            sUserSession.setDob(userSession.getEmail());
        }
        if(userSession.getSex()!=null){
            sUserSession.setSex(userSession.getSex());
        }
        if(userSession.getPhone()!=null){
            sUserSession.setPhone(userSession.getPhone());
        }
        if(userSession.getDescription()!=null){
            sUserSession.setDescription(userSession.getDescription());
        }
        if(userSession.getRole()!=null){
            sUserSession.setRole(userSession.getRole());
        }
        if(userSession.getRating()!=null){
            sUserSession.setRating(userSession.getRating());
        }
        if(userSession.getFeePerHour()!=null){
            sUserSession.setFeePerHour(userSession.getFeePerHour());
        }
        if(userSession.getMonthIncome()!=null){
            sUserSession.setMonthIncome(userSession.getMonthIncome());
        }
        if(userSession.getIsActive()!=null){
            sUserSession.setIsActive(userSession.getIsActive());
        }
        if(userSession.getLongitude()!=null){
            sUserSession.setLongitude(userSession.getLongitude());
        }
        if(userSession.getLatitude()!=null){
            sUserSession.setLatitude(userSession.getLatitude());
        }
        if(userSession.getCreateDate()!=null){
            sUserSession.setCreateDate(userSession.getCreateDate());
        }
        if(userSession.getUpdateDate()!=null){
            sUserSession.setUpdateDate(userSession.getUpdateDate());
        }
        if(userSession.getDeviceUiid()!=null){
            sUserSession.setDeviceUiid(userSession.getDeviceUiid());
        }
    }

    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("user_name")
    @Expose
    private Object userName;
    @SerializedName("pwd")
    @Expose
    private Object pwd;
    @SerializedName("firstname")
    @Expose
    private String firstname;
    @SerializedName("lastname")
    @Expose
    private String lastname;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("address")
    @Expose
    private Object address;
    @SerializedName("avatar")
    @Expose
    private Object avatar;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("sex")
    @Expose
    private String sex;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("description")
    @Expose
    private Object description;
    @SerializedName("role")
    @Expose
    private String role;
    @SerializedName("rating")
    @Expose
    private Integer rating;
    @SerializedName("fee_per_hour")
    @Expose
    private Integer feePerHour;
    @SerializedName("month_income")
    @Expose
    private Object monthIncome;
    @SerializedName("is_active")
    @Expose
    private Integer isActive;
    @SerializedName("longitude")
    @Expose
    private Object longitude;
    @SerializedName("latitude")
    @Expose
    private Object latitude;
    @SerializedName("create_date")
    @Expose
    private String createDate;
    @SerializedName("update_date")
    @Expose
    private String updateDate;
    @SerializedName("device_uiid")
    @Expose
    private String deviceUiid;
    @SerializedName("token")
    @Expose
    private String token;

    /**
     *
     * @return
     * The userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     * The user_id
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     *
     * @return
     * The userName
     */
    public Object getUserName() {
        return userName;
    }

    /**
     *
     * @param userName
     * The user_name
     */
    public void setUserName(Object userName) {
        this.userName = userName;
    }

    /**
     *
     * @return
     * The pwd
     */
    public Object getPwd() {
        return pwd;
    }

    /**
     *
     * @param pwd
     * The pwd
     */
    public void setPwd(Object pwd) {
        this.pwd = pwd;
    }

    /**
     *
     * @return
     * The firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     *
     * @param firstname
     * The firstname
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     *
     * @return
     * The lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     *
     * @param lastname
     * The lastname
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    /**
     *
     * @return
     * The dob
     */
    public String getDob() {
        return dob;
    }

    /**
     *
     * @param dob
     * The dob
     */
    public void setDob(String dob) {
        this.dob = dob;
    }

    /**
     *
     * @return
     * The email
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * The email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     * The address
     */
    public Object getAddress() {
        return address;
    }

    /**
     *
     * @param address
     * The address
     */
    public void setAddress(Object address) {
        this.address = address;
    }

    /**
     *
     * @return
     * The avatar
     */
    public Object getAvatar() {
        return avatar;
    }

    /**
     *
     * @param avatar
     * The avatar
     */
    public void setAvatar(Object avatar) {
        this.avatar = avatar;
    }

    /**
     *
     * @return
     * The country
     */
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     * The country
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @return
     * The sex
     */
    public String getSex() {
        return sex;
    }

    /**
     *
     * @param sex
     * The sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     *
     * @return
     * The phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone
     * The phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @return
     * The description
     */
    public Object getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(Object description) {
        this.description = description;
    }

    /**
     *
     * @return
     * The role
     */
    public String getRole() {
        return role;
    }

    /**
     *
     * @param role
     * The role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     *
     * @return
     * The rating
     */
    public Integer getRating() {
        return rating;
    }

    /**
     *
     * @param rating
     * The rating
     */
    public void setRating(Integer rating) {
        this.rating = rating;
    }

    /**
     *
     * @return
     * The feePerHour
     */
    public Integer getFeePerHour() {
        return feePerHour;
    }

    /**
     *
     * @param feePerHour
     * The fee_per_hour
     */
    public void setFeePerHour(Integer feePerHour) {
        this.feePerHour = feePerHour;
    }

    /**
     *
     * @return
     * The monthIncome
     */
    public Object getMonthIncome() {
        return monthIncome;
    }

    /**
     *
     * @param monthIncome
     * The month_income
     */
    public void setMonthIncome(Object monthIncome) {
        this.monthIncome = monthIncome;
    }

    /**
     *
     * @return
     * The isActive
     */
    public Integer getIsActive() {
        return isActive;
    }

    /**
     *
     * @param isActive
     * The is_active
     */
    public void setIsActive(Integer isActive) {
        this.isActive = isActive;
    }

    /**
     *
     * @return
     * The longitude
     */
    public Object getLongitude() {
        return longitude;
    }

    /**
     *
     * @param longitude
     * The longitude
     */
    public void setLongitude(Object longitude) {
        this.longitude = longitude;
    }

    /**
     *
     * @return
     * The latitude
     */
    public Object getLatitude() {
        return latitude;
    }

    /**
     *
     * @param latitude
     * The latitude
     */
    public void setLatitude(Object latitude) {
        this.latitude = latitude;
    }

    /**
     *
     * @return
     * The createDate
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     *
     * @param createDate
     * The create_date
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    /**
     *
     * @return
     * The updateDate
     */
    public String getUpdateDate() {
        return updateDate;
    }

    /**
     *
     * @param updateDate
     * The update_date
     */
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    /**
     *
     * @return
     * The deviceUiid
     */
    public String getDeviceUiid() {
        return deviceUiid;
    }

    /**
     *
     * @param deviceUiid
     * The device_uiid
     */
    public void setDeviceUiid(String deviceUiid) {
        this.deviceUiid = deviceUiid;
    }

    /**
     *
     * @return
     * The token
     */
    public String getToken() {
        return token;
    }

    /**
     *
     * @param token
     * The token
     */
    public void setToken(String token) {
        this.token = token;
    }

}