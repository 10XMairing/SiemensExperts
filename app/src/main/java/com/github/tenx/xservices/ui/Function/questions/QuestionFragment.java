package com.github.tenx.xservices.ui.Function.questions;


import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.github.tenx.xservices.R;
import com.github.tenx.xservices.utils.FileUtil;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.Snackbar;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.support.AndroidSupportInjection;

import static android.app.Activity.RESULT_OK;

/**
 * A simple {@link Fragment} subclass.
 */
public class QuestionFragment extends Fragment {

    @BindView(R.id.text_input_layout)
    EditText questionBody;
    @BindView(R.id.btn_images)
    MaterialButton btnImages;
    @BindView(R.id.btn_post)
    MaterialButton btnPost;
    @BindView(R.id.image)
    ImageView imageView;
    @BindView(R.id.relLayout)
    RelativeLayout relLayout;

    public static final int REQUEST_CODE_IMAGE = 121;
    private File imageFile = null;
    private static final String TAG = "QuestionFragment";


    @Inject
    public QuestionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_question, container, false);

        AndroidSupportInjection.inject(this);

        ButterKnife.bind(this, view);


        return view;
    }

    @Override
    public void onAttach(Context context) {

        AndroidSupportInjection.inject(this);
        super.onAttach(context);
    }

    @OnClick({R.id.btn_images, R.id.btn_post})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_images:
                searchImage();
                break;
            case R.id.btn_post:
                postQuestion();
                break;
        }
    }

    private void postQuestion() {

            String postBody = questionBody.getText().toString();
            if (TextUtils.isEmpty(postBody)) {
                Snackbar.make(relLayout, "Post content cannot be empty", Snackbar.LENGTH_SHORT).show();
                return;
            }

      //  Toast.makeText(getActivity(), ""+postBody, Toast.LENGTH_SHORT).show();


           // viewModel.postNewQuery(postBody,imageFile);

    }

    private void searchImage() {

        Dexter.withActivity(getActivity()).withPermission(Manifest.permission.READ_EXTERNAL_STORAGE).withListener(new PermissionListener() {
            @Override
            public void onPermissionGranted(PermissionGrantedResponse response) {

                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,"Select a Image"),REQUEST_CODE_IMAGE);


            }

            @Override
            public void onPermissionDenied(PermissionDeniedResponse response) {
                Toast.makeText(getActivity(), "You need to give read access", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {

            }
        }).check();

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE_IMAGE) {
            if (resultCode == RESULT_OK) {
                Uri uri = data.getData();
                imageFile = getFile(uri);
                try {
                    Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
                    imageView.setImageBitmap(bitmap);

                } catch (FileNotFoundException e) {
                    throw new Error("File not found");
                } catch (IOException e) {
                    throw new Error("IO exception");
                }
            }
        }
    }


    public File getFile(Uri uri) {
        try {
            File file = FileUtil.from(getActivity(), uri);
            Log.d("file", "File...:::: uti - " + file.getPath() + " file -" + file + " : " + file.exists());

            return file;

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
