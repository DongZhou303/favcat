package com.favcat.fragment;

import java.io.Serializable;
import java.util.List;

public class CatDataList {
    private List<Breeds> breeds;
    private String id;
    private String url;
    private int width;
    private int height;

    public void setBreeds(List<Breeds> breeds) {
        this.breeds = breeds;
    }

    public List<Breeds> getBreeds() {
        return breeds;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "CatListBean{" +
                "breeds=" + breeds +
                ", id='" + id + '\'' +
                ", url='" + url + '\'' +
                ", width=" + width +
                ", height=" + height +
                '}';
    }

    public class Weight implements Serializable {

        private String imperial;
        private String metric;

        public void setImperial(String imperial) {
            this.imperial = imperial;
        }

        public String getImperial() {
            return imperial;
        }

        public void setMetric(String metric) {
            this.metric = metric;
        }

        public String getMetric() {
            return metric;
        }

        @Override
        public String toString() {
            return
                    "imperial=" + imperial +"," + '\n' +
                            "metric=" + metric;
        }
    }

    public class Breeds implements Serializable {

        private Weight weight;
        private String id;
        private String name;
        private String cfa_url;
        private String vetstreet_url;
        private String vcahospitals_url;
        private String temperament;
        private String origin;
        private String country_codes;
        private String country_code;
        private String description;
        private String life_span;
        private int indoor;
        private int lap;
        private int adaptability;
        private int affection_level;
        private int child_friendly;
        private int cat_friendly;
        private int dog_friendly;
        private int energy_level;
        private int grooming;
        private int health_issues;
        private int intelligence;
        private int shedding_level;
        private int social_needs;
        private int stranger_friendly;
        private int vocalisation;
        private int bidability;
        private int experimental;
        private int hairless;
        private int natural;
        private int rare;
        private int rex;
        private int suppressed_tail;
        private int short_legs;
        private String wikipedia_url;
        private int hypoallergenic;

        public void setWeight(Weight weight) {
            this.weight = weight;
        }

        public Weight getWeight() {
            return weight;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setCfa_url(String cfa_url) {
            this.cfa_url = cfa_url;
        }

        public String getCfa_url() {
            return cfa_url;
        }

        public void setVetstreet_url(String vetstreet_url) {
            this.vetstreet_url = vetstreet_url;
        }

        public String getVetstreet_url() {
            return vetstreet_url;
        }

        public void setVcahospitals_url(String vcahospitals_url) {
            this.vcahospitals_url = vcahospitals_url;
        }

        public String getVcahospitals_url() {
            return vcahospitals_url;
        }

        public void setTemperament(String temperament) {
            this.temperament = temperament;
        }

        public String getTemperament() {
            return temperament;
        }

        public void setOrigin(String origin) {
            this.origin = origin;
        }

        public String getOrigin() {
            return origin;
        }

        public void setCountry_codes(String country_codes) {
            this.country_codes = country_codes;
        }

        public String getCountry_codes() {
            return country_codes;
        }

        public void setCountry_code(String country_code) {
            this.country_code = country_code;
        }

        public String getCountry_code() {
            return country_code;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        public void setLife_span(String life_span) {
            this.life_span = life_span;
        }

        public String getLife_span() {
            return life_span;
        }

        public void setIndoor(int indoor) {
            this.indoor = indoor;
        }

        public int getIndoor() {
            return indoor;
        }

        public void setLap(int lap) {
            this.lap = lap;
        }

        public int getLap() {
            return lap;
        }

        public void setAdaptability(int adaptability) {
            this.adaptability = adaptability;
        }

        public int getAdaptability() {
            return adaptability;
        }

        public void setAffection_level(int affection_level) {
            this.affection_level = affection_level;
        }

        public int getAffection_level() {
            return affection_level;
        }

        public void setChild_friendly(int child_friendly) {
            this.child_friendly = child_friendly;
        }

        public int getChild_friendly() {
            return child_friendly;
        }

        public void setCat_friendly(int cat_friendly) {
            this.cat_friendly = cat_friendly;
        }

        public int getCat_friendly() {
            return cat_friendly;
        }

        public void setDog_friendly(int dog_friendly) {
            this.dog_friendly = dog_friendly;
        }

        public int getDog_friendly() {
            return dog_friendly;
        }

        public void setEnergy_level(int energy_level) {
            this.energy_level = energy_level;
        }

        public int getEnergy_level() {
            return energy_level;
        }

        public void setGrooming(int grooming) {
            this.grooming = grooming;
        }

        public int getGrooming() {
            return grooming;
        }

        public void setHealth_issues(int health_issues) {
            this.health_issues = health_issues;
        }

        public int getHealth_issues() {
            return health_issues;
        }

        public void setIntelligence(int intelligence) {
            this.intelligence = intelligence;
        }

        public int getIntelligence() {
            return intelligence;
        }

        public void setShedding_level(int shedding_level) {
            this.shedding_level = shedding_level;
        }

        public int getShedding_level() {
            return shedding_level;
        }

        public void setSocial_needs(int social_needs) {
            this.social_needs = social_needs;
        }

        public int getSocial_needs() {
            return social_needs;
        }

        public void setStranger_friendly(int stranger_friendly) {
            this.stranger_friendly = stranger_friendly;
        }

        public int getStranger_friendly() {
            return stranger_friendly;
        }

        public void setVocalisation(int vocalisation) {
            this.vocalisation = vocalisation;
        }

        public int getVocalisation() {
            return vocalisation;
        }

        public void setBidability(int bidability) {
            this.bidability = bidability;
        }

        public int getBidability() {
            return bidability;
        }

        public void setExperimental(int experimental) {
            this.experimental = experimental;
        }

        public int getExperimental() {
            return experimental;
        }

        public void setHairless(int hairless) {
            this.hairless = hairless;
        }

        public int getHairless() {
            return hairless;
        }

        public void setNatural(int natural) {
            this.natural = natural;
        }

        public int getNatural() {
            return natural;
        }

        public void setRare(int rare) {
            this.rare = rare;
        }

        public int getRare() {
            return rare;
        }

        public void setRex(int rex) {
            this.rex = rex;
        }

        public int getRex() {
            return rex;
        }

        public void setSuppressed_tail(int suppressed_tail) {
            this.suppressed_tail = suppressed_tail;
        }

        public int getSuppressed_tail() {
            return suppressed_tail;
        }

        public void setShort_legs(int short_legs) {
            this.short_legs = short_legs;
        }

        public int getShort_legs() {
            return short_legs;
        }

        public void setWikipedia_url(String wikipedia_url) {
            this.wikipedia_url = wikipedia_url;
        }

        public String getWikipedia_url() {
            return wikipedia_url;
        }

        public void setHypoallergenic(int hypoallergenic) {
            this.hypoallergenic = hypoallergenic;
        }

        public int getHypoallergenic() {
            return hypoallergenic;
        }

        @Override
        public String toString() {
            return "Breeds{" +
                    "weight=" + weight +
                    ", id='" + id + '\'' +
                    ", name='" + name + '\'' +
                    ", cfa_url='" + cfa_url + '\'' +
                    ", vetstreet_url='" + vetstreet_url + '\'' +
                    ", vcahospitals_url='" + vcahospitals_url + '\'' +
                    ", temperament='" + temperament + '\'' +
                    ", origin='" + origin + '\'' +
                    ", country_codes='" + country_codes + '\'' +
                    ", country_code='" + country_code + '\'' +
                    ", description='" + description + '\'' +
                    ", life_span='" + life_span + '\'' +
                    ", indoor=" + indoor +
                    ", lap=" + lap +
                    ", adaptability=" + adaptability +
                    ", affection_level=" + affection_level +
                    ", child_friendly=" + child_friendly +
                    ", cat_friendly=" + cat_friendly +
                    ", dog_friendly=" + dog_friendly +
                    ", energy_level=" + energy_level +
                    ", grooming=" + grooming +
                    ", health_issues=" + health_issues +
                    ", intelligence=" + intelligence +
                    ", shedding_level=" + shedding_level +
                    ", social_needs=" + social_needs +
                    ", stranger_friendly=" + stranger_friendly +
                    ", vocalisation=" + vocalisation +
                    ", bidability=" + bidability +
                    ", experimental=" + experimental +
                    ", hairless=" + hairless +
                    ", natural=" + natural +
                    ", rare=" + rare +
                    ", rex=" + rex +
                    ", suppressed_tail=" + suppressed_tail +
                    ", short_legs=" + short_legs +
                    ", wikipedia_url='" + wikipedia_url + '\'' +
                    ", hypoallergenic=" + hypoallergenic +
                    '}';
        }
    }
}
