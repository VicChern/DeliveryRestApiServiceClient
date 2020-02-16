package dto;

import java.util.List;
import java.util.Objects;

public class AddressesList {
    private List<Address> addresses;

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AddressesList)) return false;
        AddressesList that = (AddressesList) o;
        return Objects.equals(addresses, that.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(addresses);
    }

    @Override
    public String toString() {
        return "AddressesList{" +
                "addresses=" + addresses +
                '}';
    }
}
