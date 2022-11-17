package com.example.droi_mvvm.util;//package com.dreamsolutech.jk_kotlin.util;
//
//import android.Manifest;
//import android.content.Context;
//import android.hardware.Sensor;
//import android.hardware.SensorEvent;
//import android.hardware.SensorEventListener;
//import android.hardware.SensorManager;
//import android.os.Build;
//
//import com.dreamsolutech.openingbox.R;
//import com.gun0912.tedpermission.PermissionListener;
//import com.gun0912.tedpermission.TedPermission;
//
//import java.util.List;
//
//public class Pedometer {
//    private static int mSteps = 0;
//    //리스너가 등록되고 난 후의 step count
//    private static int mCounterSteps = 0;
//    //센서 연결을 위한 변수
//    private static SensorManager sensorManager;
//    //private Sensor accelerormeterSensor;
//    private static Sensor stepCountSensor;
//
//    public static void pedometer(Context context) {
//        //센서 연결[걸음수 센서를 이용한 흔듬 감지]
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
//            TedPermission.with(context)
//                    .setPermissionListener(new PermissionListener() { //퍼미션 획득
//                        @Override
//                        public void onPermissionGranted() {
//                            sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
//                            //accelerormeterSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
//                            assert sensorManager != null;
//                            stepCountSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
//                            if (stepCountSensor != null) {
//                                //센서의 속도 설정
//                                sensorManager.registerListener(sensorEventListener, stepCountSensor, SensorManager.SENSOR_DELAY_UI);
//                            }
////                            if (sensorManager != null) {
////                                sensorManager.unregisterListener(sensorEventListener);
////                            }
//                            Logger.loge("mSteps   :  " + mSteps + "    mCounterSteps   :  " + mCounterSteps);
//                        }
//
//                        @Override
//                        public void onPermissionDenied(List<String> deniedPermissions) {
//
//                        }
//                    })
//                    //                .setRationaleMessage("이거이거 저거저거")
//                    //                .setRationaleConfirmText("화기하기")
//                    .setDeniedMessage(context.getString(R.string.app_permission))
//                    .setPermissions(Manifest.permission.ACTIVITY_RECOGNITION
//                            //                        , Manifest.permission.WRITE_EXTERNAL_STORAGE
//                    ).check();
//        } else {
//            sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
//            //accelerormeterSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
//            Logger.loge("sensorManager  :  " + sensorManager);
//            assert sensorManager != null;
//            stepCountSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER);
//            if (stepCountSensor != null) {
//                //센서의 속도 설정
//                sensorManager.registerListener(sensorEventListener, stepCountSensor, SensorManager.SENSOR_DELAY_UI);
//            }
////            if (sensorManager != null) {
////                sensorManager.unregisterListener(sensorEventListener);
////            }
////            Logger.loge("mSteps   :  " + mSteps + "    mCounterSteps   :  " + mCounterSteps);
//        }
//    }
//
//    private static SensorEventListener sensorEventListener = new SensorEventListener() {
//        @Override
//        public void onSensorChanged(SensorEvent event) {
//            if (event.sensor.getType() == Sensor.TYPE_STEP_COUNTER) {
//                //stepcountsenersor는 앱이 꺼지더라도 초기화 되지않는다. 그러므로 우리는 초기값을 가지고 있어야한다.
//                if (mCounterSteps < 1) {
//                    // initial value
//                    mCounterSteps = (int) event.values[0];
//                }
//                //리셋 안된 값 + 현재값 - 리셋 안된 값
//                mSteps = (int) event.values[0] - mCounterSteps;
//                Logger.loge("mSteps   :  " + mSteps + "    mCounterSteps   :  " + mCounterSteps);
//            }
//        }
//        @Override
//        public void onAccuracyChanged(Sensor sensor, int i) {
//
//        }
//    };
//}
