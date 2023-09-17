import java.math.BigDecimal;

public class Position {
    private String name;
    private BigDecimal price;
    private Integer guest;

    public Position(String name, BigDecimal price, Integer guest) {
        this.name = name;
        this.price = price;
        this.guest = guest;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGuest() {
        return guest;
    }

    public void setGuest(Integer guest) {
        this.guest = guest;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


}
