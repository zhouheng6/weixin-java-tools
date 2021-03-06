package me.chanjar.weixin.mp.bean.result;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import lombok.Data;
import me.chanjar.weixin.common.util.ToStringUtils;
import me.chanjar.weixin.mp.util.json.WxMpGsonBuilder;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 微信用户信息
 *
 * @author chanjarster
 */
@Data
public class WxMpUser implements Serializable {
  private static final long serialVersionUID = 5788154322646488738L;

  private Boolean subscribe;
  private String openId;
  private String nickname;
  private String sex;
  private String language;
  private String city;
  private String province;
  private String country;
  private String headImgUrl;
  private Long subscribeTime;
  /**
   * 只有在将公众号绑定到微信开放平台帐号后，才会出现该字段。
   */
  private String unionId;
  private Integer sexId;
  private String remark;
  private Integer groupId;
  private Long[] tagIds;

  public static WxMpUser fromJson(String json) {
    return WxMpGsonBuilder.INSTANCE.create().fromJson(json, WxMpUser.class);
  }

  public static List<WxMpUser> fromJsonList(String json) {
    Type collectionType = new TypeToken<List<WxMpUser>>() {
    }.getType();
    Gson gson = WxMpGsonBuilder.INSTANCE.create();
    JsonObject jsonObject = gson.fromJson(json, JsonObject.class);
    return gson.fromJson(jsonObject.get("user_info_list"), collectionType);
  }

  @Override
  public String toString() {
    return ToStringUtils.toSimpleString(this);
  }

}
