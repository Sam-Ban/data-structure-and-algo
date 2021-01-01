package practice.designpattern.creational.builder;

public class Material {

    private String materialId;
    private String materialTypeCde;
    private String gpl;
    private String productOwningBU;
    private String department;


    private Material(MaterialBuilder builder){
            this.materialId=builder.materialId;
            this.materialTypeCde=builder.materialTypeCde;
            this.gpl=builder.gpl;
            this.productOwningBU=builder.productOwningBU;
            this.department=builder.department;
    }

    public String getMaterialId() {
        return materialId;
    }

    public String getMaterialTypeCde() {
        return materialTypeCde;
    }

    public String getGpl() {
        return gpl;
    }

    public String getProductOwningBU() {
        return productOwningBU;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Material{" +
                "materialId='" + materialId + '\'' +
                ", materialTypeCde='" + materialTypeCde + '\'' +
                ", gpl='" + gpl + '\'' +
                ", productOwningBU='" + productOwningBU + '\'' +
                ", department='" + department + '\'' +
                '}';
    }

    public static class MaterialBuilder{
        private String materialId;
        private String materialTypeCde;
        private String gpl;
        private String productOwningBU;
        private String department;

        public MaterialBuilder(String materialId,String materialTypeCde){
            this.materialId=materialId;
            this.materialTypeCde=materialTypeCde;
        }
        public MaterialBuilder gpl(String gpl){
            this.gpl = gpl;
            return this;
        }
        public MaterialBuilder productOwingBU(String productOwningBU){
            this.productOwningBU=productOwningBU;
            return this;
        }
        public MaterialBuilder department(String department){
            this.department=department;
            return this;
        }
        //Return a finally constructed object
        public Material build(){
            Material material=new Material(this);
            return material;
        }

    }

}
