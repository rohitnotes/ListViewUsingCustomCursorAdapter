package list.view.using.custom.cursor.adapter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class ListViewActivity extends AppCompatActivity {

    private Context context = ListViewActivity.this;
    private SQLiteDatabaseHelper sqLiteDatabaseHelper;
    private ListView listView;
    private String firstNameString,lastNameString,branchString,rollNumberString,gradeString,contactNumberString;
    private CustomCursorAdapter customCursorAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        initView();
        insertDataInTable();
        customCursorAdapter = new CustomCursorAdapter(context, sqLiteDatabaseHelper.getCursor());
        listView.setAdapter(customCursorAdapter);
    }

    private void initView()
    {
        sqLiteDatabaseHelper = new SQLiteDatabaseHelper(getApplicationContext());
        listView=findViewById(R.id.list_view);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int position, long arg3) {
                Toast toast = Toast.makeText(getApplicationContext(), ""+position, Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
                toast.show();
            }
        });
    }

    private void insertDataInTable()
    {
        sqLiteDatabaseHelper.formatTableDetail();
        for (int i = 0; i < 5; i++)
        {
            firstNameString     = "Rohit ";
            lastNameString      = "Yadav_"+i;
            branchString        = "Computer Science_"+i;
            rollNumberString    = "0862CS14108"+i;
            gradeString         = "A"+i;
            contactNumberString = "789868030"+i;
            CollageStudentDetailModel collageStudentModel = new 			CollageStudentDetailModel(firstNameString,lastNameString,branchString,rollNumberString,gradeString,contactNumberString);
            sqLiteDatabaseHelper.insertOperation(collageStudentModel);
        }
    }
}
