import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Check {
    private Integer countPerson;
    private List<Position> positionList;

    private BigDecimal summOfCheck;

    public Integer getCountPerson() {
        return countPerson;
    }

    public void setCountPerson(Integer countPerson) {
        this.countPerson = countPerson;
    }

    public List<Position> getPositionList() {
        return positionList;
    }

    public void setPositionList(List<Position> positionList) {
        this.positionList = positionList;
    }

    public Check() {
        this.summOfCheck=BigDecimal.ZERO;
        this.positionList=new ArrayList<>();
    }

    public void addPosition(Position position){
        this.positionList.add(position);
        this.summOfCheck=this.summOfCheck.add(position.getPrice());
    }

    public BigDecimal getTotalSum(){
        return this.summOfCheck;
    }

}
