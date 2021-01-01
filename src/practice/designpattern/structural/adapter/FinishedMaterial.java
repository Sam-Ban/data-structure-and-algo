package practice.designpattern.structural.adapter;

public class FinishedMaterial implements Material {

    private String materialId;
    private String materialDesc;

    public FinishedMaterial(String materialId,String materialDesc){
    this.materialId= materialId;
    this.materialDesc = materialDesc;
    }

    public void setMaterialId(String materialId) {
        this.materialId = materialId;
    }

    public void setMaterialDesc(String materialDesc) {
        this.materialDesc = materialDesc;
    }

    @Override
    public String getMaterialId() {
        return materialId;
    }
    @Override
    public String getMaterialDesc() {
        return materialDesc;
    }

    @Override
    public String toString() {
        return "FinishedMaterial{" +
                "materialId='" + materialId + '\'' +
                ", materialDesc='" + materialDesc + '\'' +
                '}';
    }
}
