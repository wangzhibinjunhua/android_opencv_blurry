package org.opencv.samples.facedetect;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.BlurDetect;
import org.opencv.android.LoaderCallbackInterface;
import org.opencv.android.LogUtil;
import org.opencv.android.OpenCVLoader;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import junit.framework.Test;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

	}

	// openCV4Android 需要加载用到
	private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
		@Override
		public void onManagerConnected(int status) {
			switch (status) {
			case LoaderCallbackInterface.SUCCESS: {
				LogUtilNew.log("OpenCV loaded successfully");
				// mOpenCvCameraView.enableView();
				// mOpenCvCameraView.setOnTouchListener(ColorBlobDetectionActivity.this);
			}
				break;
			default: {
				super.onManagerConnected(status);
			}
				break;
			}
		}
	};

	@Override
	public void onResume() {
		super.onResume();
		if (!OpenCVLoader.initDebug()) {
			LogUtilNew.log("Internal OpenCV library not found. Using OpenCV Manager for initialization");
			// OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_0_0, this,
			// mLoaderCallback);
			mLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS);
		} else {
			LogUtilNew.log("OpenCV library found inside package. Using it!");
			mLoaderCallback.onManagerConnected(LoaderCallbackInterface.SUCCESS);
		}

		test();
	}

	void test() {
		Boolean result = BlurDetect.isBlurByOpenCV("/sdcard/images/image_001.png");
		LogUtil.log("001: result=" + result);
		LogUtil.log("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		result = BlurDetect.isBlurByOpenCV("/sdcard/images/image_002.png");
		LogUtil.log("002: result=" + result);
		LogUtil.log("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		result = BlurDetect.isBlurByOpenCV("/sdcard/images/image_003.png");
		LogUtil.log("003: result=" + result);
		LogUtil.log("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		result = BlurDetect.isBlurByOpenCV("/sdcard/images/image_004.png");
		LogUtil.log("004: result=" + result);
		LogUtil.log("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		result = BlurDetect.isBlurByOpenCV("/sdcard/images/image_005.png");
		LogUtil.log("005: result=" + result);
		LogUtil.log("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		result = BlurDetect.isBlurByOpenCV("/sdcard/images/image_013.jpg");
		LogUtil.log("013: result=" + result);
		LogUtil.log("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		result = BlurDetect.isBlurByOpenCV("/sdcard/images/image_014.jpg");
		LogUtil.log("014: result=" + result);
		LogUtil.log("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
	}

}
