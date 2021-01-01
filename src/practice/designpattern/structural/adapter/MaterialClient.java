package practice.designpattern.structural.adapter;

import java.util.ArrayList;
import java.util.List;

public class MaterialClient {
    public List<Material> getMaterialList(){
        List<Material> materials = new ArrayList<>();
        Material finishedMaterial = new FinishedMaterial("928999-1","MQ6 : Connector");
        materials.add(finishedMaterial);
        RawMaterial rawMaterial = new RawMaterial("967067-1","RM01 : Copper");
        materials.add(new RawMaterialAdapter(rawMaterial));
        return materials;
    }
}
