package practice.designpattern.structural.adapter;

public class RawMaterialAdapter implements Material {

    private RawMaterial instance;

    public RawMaterialAdapter(RawMaterial rawMaterial) {
        this.instance = rawMaterial;
    }

    @Override
    public String getMaterialId() {
        return instance.getRid();
    }

    @Override
    public String getMaterialDesc() {
        return instance.getRdesc();
    }
}
