package com.kymjs.mvpvm.demo.data;

import com.kymjs.mvpvm.model.IModel;

import java.util.ArrayList;
import java.util.List;

public class MVVMData implements IModel {

    private List<ModuleData> moduleDataList = new ArrayList<>();

    public List<ModuleData> getModuleDataList() {
        return moduleDataList;
    }

    public void setModuleDataList(List<ModuleData> moduleDataList) {
        this.moduleDataList = moduleDataList;
    }

    public static class ModuleData {
        /**
         * entityList : [{"imgUrl":"https://img01.yit.com/CMSRESQN/dcd43c22dd62c54ba94490f331421169_750X500.jpeg","dailyPrice":0,"price":0,"productName":"","spuId":0},{"imgUrl":"https://img01.yit.com/CMSRESQN/dc8bb33356e5d170f2801107bd7f7808_750X500.jpeg","dailyPrice":0,"price":0,"productName":"","spuId":0},{"imgUrl":"https://img01.yit.com/CMSRESQN/6c0d8031876002a3ca9f22af35e162d5_750X500.jpeg","dailyPrice":0,"price":0,"productName":"","spuId":0},{"imgUrl":"https://img01.yit.com/CMSRESQN/75bb1a6ed54536d463b17389a96c60b8_750X500.jpeg","dailyPrice":0,"price":0,"productName":"","spuId":0},{"imgUrl":"https://img01.yit.com/CMSRESQN/442940f3806df0cb9d2e8b0ab7f50d78_750X500.jpeg","dailyPrice":0,"price":0,"productName":"","spuId":0},{"imgUrl":"https://img01.yit.com/CMSRESQN/1375610442c49ffbddc2efc15e21288a_750X500.jpeg","dailyPrice":0,"price":0,"productName":"","spuId":0},{"imgUrl":"https://img01.yit.com/CMSRESQN/beed0bd563e3340868e825618a9cdb98_750X500.jpeg","dailyPrice":0,"price":0,"productName":"","spuId":0}]
         * type : slider
         */

        private String type;
        private List<Product> entityList;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public List<Product> getEntityList() {
            return entityList;
        }

        public void setEntityList(List<Product> entityList) {
            this.entityList = entityList;
        }
    }
}
