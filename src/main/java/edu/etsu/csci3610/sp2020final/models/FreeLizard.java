// Added by Destin
// Models the free lizard raffle registration

package edu.etsu.csci3610.sp2020final.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class FreeLizard {

    @NotNull
    @Size(min=2, max=30)
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String content) {
        this.name = content;
    }

    @Override
    public String toString() {
        return "Free Lizard Registration(Name: " + this.name + ")";
    }
}
