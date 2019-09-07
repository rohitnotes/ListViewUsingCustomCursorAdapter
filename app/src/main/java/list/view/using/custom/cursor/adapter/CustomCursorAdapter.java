package list.view.using.custom.cursor.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class CustomCursorAdapter extends CursorAdapter
{
    private Cursor cursor;

    CustomCursorAdapter(Context context, Cursor cursorConstruct)
    {
        super(context, cursorConstruct, 0);
        cursor=cursorConstruct;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

        TextView nameTextView           = view.findViewById(R.id.name_text_view);
        TextView branchTextView         = view.findViewById(R.id.branch_text_view);
        TextView rollNumberTextView     = view.findViewById(R.id.roll_number_text_view);
        TextView gradeTextView          = view.findViewById(R.id.grade_text_view);
        TextView contactNumberTextView  = view.findViewById(R.id.contact_number_text_view);

        String firstNameString     = cursor.getString(cursor.getColumnIndex(Constants.COLUMN_2));
        String lastNameString      = cursor.getString(cursor.getColumnIndex(Constants.COLUMN_3));
        String branchString        = cursor.getString(cursor.getColumnIndex(Constants.COLUMN_4));
        String rollNumberString    = cursor.getString(cursor.getColumnIndex(Constants.COLUMN_5));
        String gradeString         = cursor.getString(cursor.getColumnIndex(Constants.COLUMN_6));
        String contactNumberString = cursor.getString(cursor.getColumnIndex(Constants.COLUMN_7));

        nameTextView.setText(firstNameString+" "+lastNameString);
        branchTextView.setText(branchString);
        rollNumberTextView.setText(rollNumberString);
        gradeTextView.setText(gradeString);
        contactNumberTextView.setText(contactNumberString);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_item, parent, false);
        bindView(view, context, cursor);
        return view;
    }

    public int getCount() {
        // TODO Auto-generated method stub
        return cursor.getCount();
    }

    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }
}
