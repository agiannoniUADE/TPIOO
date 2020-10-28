package modelo;

public class ColorItem {
    private int codigo;
    private String descripcion;

    public ColorItem(int codigo, String descripcion)
    {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public int getCodigo()
    {
        return this.codigo;
    }

    public String getDescripcion()
    {
        return this.descripcion;
    }

    public String toString()
    {
        return this.descripcion;
    }

}
