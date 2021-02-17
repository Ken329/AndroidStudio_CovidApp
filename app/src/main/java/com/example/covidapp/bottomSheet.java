package com.example.covidapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class bottomSheet {
    String action;
    Context context;
    public bottomSheet(String action, Context context){
        this.action = action;
        this.context = context;
    }
    public void getBottomSheet(){
        BottomSheetDialog bottom = new BottomSheetDialog(context, R.style.BottomSheetDialogTheme);
        View view = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.bottom_layout, null);
        ImageView image = view.findViewById(R.id.bottomSheetImage);
        TextView title = view.findViewById(R.id.bottomSheetTitle);
        TextView text = view.findViewById(R.id.bottomSheetText);

        switch (action){
            case "mask":
                image.setImageResource(R.mipmap.mask_foreground);
                title.setText("Wear Your Mask");
                text.setText("Washing hands with soap and water is the best way to get rid of germs in most situations. If soap and water are not readily available, you can use an alcohol-based hand sanitizer that contains at least 60% alcohol. " +
                        "You can tell if the sanitizer contains at least 60% alcohol by looking at the product label.");
                break;
            case "distance":
                image.setImageResource(R.mipmap.diatance_foreground);
                title.setText("Keep Your Distance");
                text.setText("Around the world, public officials are asking people who have contracted or been exposed to the new coronavirus to practice social distancing, quarantine or isolation measures in an effort to slow disease’s spread. " +
                        "Social distancing means keeping a safe distance (approximately 6 feet) from others and avoiding gathering spaces such as schools, churches, concert halls and public transportation.");
                break;
            case "wash":
                image.setImageResource(R.mipmap.wash_hand_foreground);
                title.setText("Wash Your Hand");
                text.setText("Covers your nose and mouth and secure it under your chin. " +
                        "Fits snugly against the sides of your face. "+"Be sure to wash your hands or use hand sanitizer before putting on a mask. " +
                        "Do NOT touch the mask when wearing it. If you have to often touch/adjust your mask, it doesn’t fit you properly, and you may need to find a different mask or make adjustments.");
                break;
            case "risk":
                image.setImageResource(R.mipmap.high_risk_foreground);
                title.setText("High Risk");
                text.setText("Older adults are more likely to have long-term health problems that can put them at risk. " +
                        "People’s immune systems tend to weaken with age, making it more difficult for older people to fight off infections. " +
                        "Lung tissue becomes less elastic over time, making respiratory diseases like COVID-19 a particular concern for older people. " +
                        "Inflammation in older people can be more intense, causing organ damage.");
                break;
            case "care":
                image.setImageResource(R.mipmap.health_care_foreground);
                title.setText("Health Care");
                text.setText("The COVID-19 pandemic has had a major impact on the capacity of health systems to continue the delivery of essential health services. " +
                        "While health systems around the world are being challenged by increasing demand for care of COVID-19 patients, it is critical to maintain preventive and curative services, especially for the most vulnerable populations, such as children, older persons, people living with chronic conditions, minorities and people living with disabilities.\n" +
                        "Countries need to achieve the optimal balance between fighting the COVID-19 pandemic and maintenance of essential health services. WHO has been coordinating efforts across several regions and departments to support country implementation of targeted actions to reorganize and maintain access to safe and high-quality essential health services across the life course. ");
                break;
            case "test":
                image.setImageResource(R.mipmap.doctor_foreground);
                title.setText("Do Your Test");
                text.setText("People who have symptoms of COVID-19. People who have had close contact (within 6 feet for a total of 15 minutes or more) with someone with confirmed COVID-19. " +
                        "People who have taken part in activities that put them at higher risk for COVID-19 because they cannot socially distance as needed, such as travel, attending large social or mass gatherings, or being in crowded indoor settings." +
                        "You can visit your state or localexternal icon health department’s website to look for the latest local information on testing. " +
                        "If you have symptoms of COVID-19 and want to get tested, call your healthcare provider first.");
                break;
        }
        bottom.setContentView(view);
        bottom.show();
    }
}
