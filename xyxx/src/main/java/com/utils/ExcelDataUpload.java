package com.utils;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.pojo.Chengji;
import com.service.ChengjiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class ExcelDataUpload extends AnalysisEventListener<Chengji> {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExcelDataUpload.class);
    /**
     * 每隔5条存储数据库，实际使用中可以3000条，然后清理list ，方便内存回收
     */
    private static final int BATCH_COUNT = 5;
    List<Chengji> list = new ArrayList<Chengji>();


    // 成绩导入service层
    private ChengjiService chengjiService;

    // 用构造函数将chengjiService传进来
    public ExcelDataUpload (ChengjiService chengjiServic) {
        this.chengjiService = chengjiServic;
    }


    /**
     * 这个每一条数据解析都会来调用
     *
     * @param data
     *            one row value. Is is same as {@link AnalysisContext#readRowHolder()}
     * @param context
     */
    @Override
    public void invoke(Chengji data, AnalysisContext context) {
        list.add(data);
        // 达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if (list.size() >= BATCH_COUNT) {
            // 调用存储数据的函数
            saveData();
            // 存储完成清理 list
            list.clear();
        }
    }

    /**
     * 所有数据解析完成了 都会来调用
     *
     * @param context
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        // 这里也要保存数据，确保最后遗留的数据也存储到数据库
        saveData();
        LOGGER.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        // LOGGER.info("{}条数据，开始存储数据库！", list.size());
        // 要存储数据就到这里写
        // 获取当前的时间 StaticMethod.getStringDate()
        for (Chengji chengji : list) {
            chengji.setDjsj(StaticMethod.getStringDate());
            chengjiService.insert(chengji);
        }
        LOGGER.info("存储数据库成功！");
    }
}
