package com.mx.zmx.admin.api.goodsimg;

import com.mx.zmx.core.service.CommonRestController;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.math.*;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import com.mx.zmx.core.common.constant.PageConstant;
import com.mx.zmx.core.common.exception.BusinessException;
import com.mx.zmx.core.serialize.ResponseMsg;
import com.mx.zmx.model.GoodsImg;
import com.mx.zmx.service.goodsimg.service.GoodsImgService;

import com.mx.zmx.core.utils.ListUtil;
import com.mx.zmx.core.utils.MapUtil;
import com.mx.zmx.core.utils.StringUtil;




@RequestMapping("/admin/goods_img_rest/")
@RestController
public class AdminGoodsImgRestController extends CommonRestController<GoodsImg,Long> implements InitializingBean
{

    @Resource
    private GoodsImgService goodsImgService;

        //分页查询
    @RequestMapping(value={"page"}, method={RequestMethod.GET})
    public ResponseMsg page(
        @RequestParam(required = false,value ="imgSrcFirst")                            String imgSrcFirst ,
        @RequestParam(required = false,value ="goodsIdFirst")                            Long goodsIdFirst ,
        @RequestParam int page,@RequestParam int limit,@RequestParam(required = false) String safeOrderBy
        ,HttpServletResponse response,@RequestParam(required = false) Integer queryType
    ){
        Map<String,Object> query = new HashMap();
        query.put("imgSrcFirst",coverBlankToNull(imgSrcFirst));
        query.put("goodsIdFirst",goodsIdFirst);
        Integer count = goodsImgService.getModelListCount(query);
        if(StringUtil.isBlank(safeOrderBy)){
            query.put("notSafeOrderBy","img_id desc");
        }else{
            query.put("safeOrderBy",safeOrderBy);
        }
        if(queryType==null || queryType == QUERY_TYPE_SEARCH){//普通查询
            limit = Math.min(limit, PageConstant.MAX_LIMIT);
            query.put("start",(page - 1) * limit);query.put("limit",limit);
            return new ResponseMsg(count,goodsImgService.getModelList(query));
        }else if(queryType == QUERY_TYPE_EXPORT_EXCEL){
            query.put("start",(page - 1) * limit);query.put("limit",limit);
            exportExcel(response,goodsImgService.getModelList(query),"商品图集",
            new String[]{"主键","图片地址","所属商品"},
            new String[]{"","",""});
        }
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        super.commonService = goodsImgService;
        super.primaryKey = "imgId";//硬编码此实体的主键名称
    }
}
