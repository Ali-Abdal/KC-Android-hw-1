package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Plants> plants = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Plants plant1 = new Plants("Cactus", R.drawable.cactus, 1.5, "Indoor", "Most cacti are only native to the Western Hemisphere. They are naturally found from the southernmost point of South America to the southern prairie region of Canada. One species, the mistletoe cactus, is the only true cactus species that is also found in the Eastern Hemisphere. This cactus does not look like a traditional one, as it is purple and shrub-like with long fingerling branches and berry-like fruit. Other cacti that are found in the Eastern Hemisphere, including Australia, are introduced species. While cacti are typically desert species, they can also be found in mountain regions and coastal plains.");
        Plants plant2 = new Plants("Palm", R.drawable.palm3, 500, "Outdoor", "Palms are flowering plants, or angiosperms, one of the two major groupings of modern-day vegetation (the other being the gymnosperms, which include conifers). They are, like grasses and orchids, monocots, producing one cotyledon or seed leaf. They achieve their greatest diversity and distribution in the tropical latitudes of the world, but they do invade the subtropics and are widely grown even in temperate regions. The most northerly palms grow in Europe, the most southerly in New Zealand.");
        Plants plant3 = new Plants("Sunflower", R.drawable.sunflower, 0.5, "Outdoor", "Sunflowers have a large flower head, usually with a large, almost black central part which is made up of thousands of tiny florets that later become seeds set in a spiral pattern. The petals are typically bright yellow, although some varieties are orange or red. Its stem is rough and hairy while the leaves large and rough with coarse jagged edges. Sunflowers typically grow to between one and a half and three and a half metres, with some giant variants reaching up to eight metres.");
        Plants plant4 = new Plants("Rose", R.drawable.rose, 0.3, "Both", "Roses are multi-petal flowers available in an array of colours. Some varieties are known for their prickles along the stems of the plant, which are used to deter predators. Many species are now cultivated although there are still varieties that grow in the wild.");
        Plants plant5 = new Plants("Bamboo", R.drawable.bamboo, 1.75, "Indoor", "Bamboos are a diverse group of evergreen perennial flowering plants making up the subfamily Bambusoideae of the grass family Poaceae. Giant bamboos are the largest members of the grass family. The origin of the word bamboo is uncertain, but it probably comes from the Dutch or Portuguese language, which originally borrowed it from Malay or Kannada.");

        plants.add(plant1);
        plants.add(plant2);
        plants.add(plant3);
        plants.add(plant4);
        plants.add(plant5);

        PlantsAdapter plantsAdapter = new PlantsAdapter(this, 0, plants);
        ListView listView = findViewById(R.id.lstview);
        listView.setAdapter(plantsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Plants currentplant = plants.get(i);
                Intent intent = new Intent(MainActivity.this, Details.class);
                intent.putExtra("plant", currentplant);
                startActivity(intent);
            }
        });
    }
}