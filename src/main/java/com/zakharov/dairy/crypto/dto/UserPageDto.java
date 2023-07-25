package com.zakharov.dairy.crypto.dto;

import com.zakharov.dairy.crypto.entity.Deal;

import java.util.List;


/**
 * Temporary use instead of UserProfileDto (Same structure only difference in classname)
 * **/
public class UserPageDto {

    private Long id;
    private String name;
    private String email;
    private List<Deal> deals;
    private double winRate;
    private long count;
    private double totalWin;
    private double totalLose;

    public UserPageDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Deal> getDeals() {
        return deals;
    }

    public void setDeals(List<Deal> deals) {
        this.deals = deals;
    }

    public double getWinRate() {
        return winRate;
    }

    public void setWinRate(double winRate) {
        this.winRate = winRate;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public double getTotalWin() {
        return totalWin;
    }

    public void setTotalWin(double totalWin) {
        this.totalWin = totalWin;
    }

    public double getTotalLose() {
        return totalLose;
    }

    public void setTotalLose(double totalLose) {
        this.totalLose = totalLose;
    }


}
